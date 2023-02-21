import {Component, Inject, Vue} from 'vue-property-decorator';
import DatabaseService from './services/database.service';
const loadingGifUrl = 'content/images/spinner.gif';
const successImgUrl = 'content/images/done.png';
const errorImgUrl = 'content/images/error.png';
@Component
export default class InjectionDatabaseSelectorComponent extends Vue {
  @Inject('databaseService') private databaseService: () => DatabaseService;

  public databases: String[] = [];

  private img : HTMLImageElement;

  public mounted() {
    this.databaseService()
      .list()
      .then(value => {
        this.databases = value;
        console.log(value);
      });

    this.img = this.$el.getElementsByTagName('img')[0]!;
  }

  public select(): void {
    const select = this.$el.getElementsByTagName('select')[0] as HTMLSelectElement;
    let dataBaseType = select.value;
    console.log(dataBaseType);
    this.showLoading();
    this.databaseService()
      .switch(dataBaseType)
      .then(() => {
        console.log('Database type switched to ' + dataBaseType);
        this.showSuccess();
      })
      .catch(reason => {
        console.error('Unable to switch database type to ' + dataBaseType + ' : ' + reason);
        this.showError();
      });
  }

  private showLoading() {
    this.img.src = loadingGifUrl;
    this.img.style.visibility = 'visible';
  }

  private showSuccess() {
    this.img.src = successImgUrl;
    this.img.style.visibility = 'visible';
  }

  private showError() {
    this.img.src = errorImgUrl;
    this.img.style.visibility = 'visible';
  }

}
