import {Component, Inject, Vue} from 'vue-property-decorator';
import DatabaseService from "@/database/services/database.service";
import InjectionDatabaseSelectorComponent from '../injection-database-selector.vue';


@Component({
  components: {
    'database-selector': InjectionDatabaseSelectorComponent
  },
})
export default class Request1Component extends Vue{

  @Inject('databaseService') private databaseService: () => DatabaseService;

  public elapsed : number = 0;
  public result11 : any = {};
  public result12 : any = {};

  async mounted() : Promise<void>{
    console.log("Request 1 component mounted");
  }

  loadData() {
    const nameTextbox = this.$el.querySelector('#name') as HTMLInputElement;
    const depthTextbox = this.$el.querySelector('#depth') as HTMLInputElement;

    this.databaseService().executeRequest1(nameTextbox.value, Number.parseInt(depthTextbox.value))
      .then(value => {
        this.elapsed = value.elapsedMsTime!;
        this.result11 = value.request11Response!;
        this.result12 = value.request12Response!;
        console.log(this.result11);
      });

  }

}
