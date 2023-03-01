const Injections = () => import('@/database/injection.vue');
const Request1 = () => import('@/database/request1/request-1.vue');

export default [
  {
    path: '/database/injection',
    component: Injections
  },
  {
    path: '/database/request/1',
    component: Request1
  }
];
