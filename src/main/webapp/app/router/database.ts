const Injections = () => import('@/database/injection.vue');
const Request1 = () => import('@/database/request1/request-1.vue');
const Request2 = () => import('@/database/request2/request-2.vue');

export default [
  {
    path: '/database/injection',
    component: Injections
  },
  {
    path: '/database/request/1',
    component: Request1
  },
  {
    path: '/database/request/2',
    component: Request2
  }
];
