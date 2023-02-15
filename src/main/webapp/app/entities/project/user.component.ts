import { Component, Provide, Vue } from 'vue-property-decorator';
import { UserProjectService } from '@/entities/project/user.service';

@Component
export default class User extends Vue {
  // @Provide('userProjectService') private userProjectService = () => new UserProjectService();

  public info: any = {
    toto: 'tata',
  };

  public init(): void {
    this.info = {
      toto: '1234',
    };
  }
}
