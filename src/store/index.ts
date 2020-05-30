import { combineReducers } from "redux";
import todos from "./reducers/todo.reducer";
import { IState } from "../interfaces/State";
import notification from "./reducers/notification.reducer";
import login from "./reducers/login.reducer";
export default combineReducers<IState>({
  todos,
  notification,
  login
});
