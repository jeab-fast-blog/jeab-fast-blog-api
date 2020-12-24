export default [
  {
    path: '/',
    component: '../layouts/BlankLayout',
    routes: [
      {
        path: '/user',
        component: '../layouts/UserLayout',
        routes: [
          {
            name: 'login',
            path: '/user/login',
            component: './user/login',
          },
        ],
      },
      {
        path: '/',
        component: '../layouts/SecurityLayout',
        routes: [
          {
            path: '/',
            component: '../layouts/BasicLayout',
            authority: ['admin', 'user'],
            routes: [
              {
                path: '/',
                redirect: '/welcome',
              },
              {
                path: '/welcome',
                name: 'welcome',
                icon: 'smile',
                component: './Welcome',
              },
              {
                path: '/admin',
                name: 'admin',
                icon: 'crown',
                component: './Admin',
                authority: ['admin'],
                routes: [
                  {
                    path: '/admin/sub-page',
                    name: 'sub-page',
                    icon: 'smile',
                    component: './Welcome',
                    authority: ['admin'],
                  },
                ],
              },
              {
                name: 'list.table-list',
                icon: 'table',
                path: '/list',
                component: './ListTableList',
              },
              {
                name: 'article',
                icon: 'read',
                path: '/article',
                //component: './ListTableList',
                routes: [
                  {
                    name: 'list',
                    path: '/article/list'
                  },
                  {
                    name: 'add',
                    path: '/article/add'
                  }
                ]
              },
              {
                name: 'category',
                icon: 'folder',
                path: '/category',
                routes: [
                  {
                    name: 'list',
                    path: '/category/list'
                  },
                  {
                    name: 'add',
                    path: '/category/add'
                  }
                ]
              },
              {
                name: 'tag',
                icon: 'tag',
                path: '/tag',
                routes: [
                  {
                    name: 'list',
                    path: '/tag/list'
                  },
                  {
                    name: 'add',
                    path: '/tag/add'
                  }
                ]
              },
              {
                name: 'comment',
                icon: 'comment',
                path: '/comment',
              },
              {
                name: 'user',
                icon: 'user',
                path: '/userList',
                component: './ListTableList',
              },
              {
                name: 'setting',
                icon: 'setting',
                path: '/system',
                component: './ListTableList',
              },
              {
                component: './404',
              },
            ],
          },
          {
            component: './404',
          },
        ],
      },
    ],
  },
  {
    component: './404',
  },
];
