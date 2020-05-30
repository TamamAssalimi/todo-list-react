import React, { lazy } from "react";

import TodoHome from "../components/statefull/TodoHome/TodoHome";
import HomeIcon from "@material-ui/icons/Home";

import PostAddIcon from "@material-ui/icons/PostAdd";
import SuspenseContainer from "../shared/Loader/Loader";
import { IRouteConfig } from "../interfaces/routeconfig.";
import LockIcon from "@material-ui/icons/Lock";

const Login = lazy(() => import("../components/stateless/Login/Login"));
const TodoAdd = lazy(() => import("../components/stateless/TodoAdd/TodoAdd"));

export const RouteConfig: IRouteConfig[] = [
  {
    path: "/",
    component: <TodoHome />,
    value: "home",
    label: "Home",
    icon: <HomeIcon />,
    goto: "/",
    isProtected: true,
    visible: true
  },
  {
    goto: "/add",
    path: "/add/:id?",
    component: (
      <SuspenseContainer>
        <TodoAdd />
      </SuspenseContainer>
    ),
    value: "add",
    label: "Add new todo",
    icon: <PostAddIcon />,
    isProtected: true,
    visible: true
  },
  
  {
    path: "/login",
    component: (
      <SuspenseContainer>
        <Login />
      </SuspenseContainer>
    ),
    icon: <LockIcon />,
    label: "Login",
    value: "Login page",
    goto: "/login",
    isProtected: false,
    visible: true
  }
];
