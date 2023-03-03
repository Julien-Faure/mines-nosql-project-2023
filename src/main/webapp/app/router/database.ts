const Injections = () => import('@/database/injection.vue');
const Request1 = () => import('@/database/request1/request-1.vue');
const Request2 = () => import('@/database/request2/request-2.vue');
const Request3 = () => import('@/database/request3/request-3.vue');

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
  },
  {
    path: '/database/request/3',
    component: Request3
  }
];
