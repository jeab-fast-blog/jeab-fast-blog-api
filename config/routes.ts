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
                name: '文章管理',
                icon: 'read',
                path: '/article',
                component: './ListTableList',
              },
              {
                name: '分类管理',
                icon: 'folder',
                path: '/category',
                component: './ListTableList',
              },
              {
                name: '标签管理',
                icon: 'tag',
                path: '/tag',
                component: './ListTableList',
              },
              {
                name: '评论管理',
                icon: 'comment',
                path: '/comment',
                component: './ListTableList',
              },
              {
                name: '用户管理',
                icon: 'user',
                path: '/userList',
                component: './ListTableList',
              },
              {
                name: '系统管理',
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
