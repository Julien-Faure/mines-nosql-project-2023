import { Component, Inject, Vue } from 'vue-property-decorator';
import DatabaseService from './services/database.service';
@Component
export default class InjectionDatabaseSelectorComponent extends Vue {
  @Inject('databaseService') private databaseService: () => DatabaseService;

  public databases: String[] = [];

  public mounted() {
    this.databaseService()
      .list()
      .then(value => {
        this.databases = value;
        console.log(value);
      });
  }

  public select(): void {
    const select = this.$el.getElementsByTagName('select')[0] as HTMLSelectElement;
    let dataBaseType = select.value;
    console.log(dataBaseType);
    this.databaseService()
      .switch(dataBaseType)
      .then(() => {
        console.log('Database type switched to ' + dataBaseType);
      })
      .catch(reason => {
        console.error('Unable to switch database type to ' + dataBaseType + ' : ' + reason);
      });
  }
}
