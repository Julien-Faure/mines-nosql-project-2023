import { Component, Provide, Vue } from 'vue-property-decorator';
@Component
export default class InjectionDatabaseSelectorComponent extends Vue {
  // @Provide('userProjectService') private userProjectService = () => new UserProjectService();

  public info: any = null;

  async mounted(): Promise<void> {
    this.info = {
      toto: '1234',
    };
  }
}