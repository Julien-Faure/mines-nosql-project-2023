import {Component, Inject, Vue} from 'vue-property-decorator';
import DatabaseService from "@/database/services/database.service";
import { PersonModel } from '@/shared/model/person.model';


@Component
export default class PersonListComponent extends Vue {
  @Inject('databaseService') private databaseService: () => DatabaseService;

  public persons : PersonModel[] = [];

  public mounted() {
    const button = this.$el.getElementsByTagName('button')[0] as HTMLButtonElement;
    button.addEventListener('click', () => {
      this.databaseService().listPerson()
        .then(value => {
          console.log(value);
        })
        .catch(reason =>  {
          console.error(`Unable to load persons : ${reason}`);
        });
    });

  }

  loadData() {
    this.databaseService().listPerson()
      .then(value => {
        this.persons = value;
      })
      .catch(reason =>  {
        console.error(`Unable to load persons : ${reason}`);
      });
  }

}
