import { Authority } from '@/shared/security/authority';
/* tslint:disable */
// prettier-ignore
const Injections = () => import('@/database/injection.vue');

// jhipster-needle-add-entity-to-router-import - JHipster will import entities to the router here

export default {
  path: '/database/injection',
  component: Injections,
};
