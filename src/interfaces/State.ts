import { TodoAppState } from "../store/reducers/todo.reducer";
import { INotificationSnackbarPayload } from "./NotificationSnackbar";
import { ILoginState } from "./login.interface";

export interface IState {
  todos: TodoAppState;
  notification: INotificationSnackbarPayload;
  login: ILoginState;
}
