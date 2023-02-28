import { Component, Provide, Vue } from 'vue-property-decorator';
import InjectionDatabaseSelectorComponent from './injection-database-selector.vue';
import PersonListComponent from './person-list.vue';
@Component({
  components: {
    'database-selector': InjectionDatabaseSelectorComponent,
    'person-list': PersonListComponent,
  },
})
export default class InjectionComponent extends Vue {
  // @Provide('userProjectService') private userProjectService = () => new UserProjectService();

  public info: any = null;

  async mounted(): Promise<void> {
    this.info = {
      toto: '1234',
    };
  }
}
