import {
  ADD_TODO,
  DELETE_TODO,
  GET_TODO,
  REMOVE_SELECTED_TODO,
  EDIT_TODO
} from "../actions/todo.action";
import { ITodoListItem } from "../../interfaces/TodoListItem";
export interface TodoAppState {
  list: ITodoListItem[];
  selectedTodo: ITodoListItem | undefined;
}

const data = [
  {
    id: "b77d409a-10cd-4a47-8e94-b0cd0ab50aa1",
    category: "Reading",
    name: "Reading news Paper",
    content:
      "Sport news Paper"
  },
  {
    id: "b77d409a-10cd-4a47-8e94-b0cd0ab50aa2",
    category: "Exercise",
    name: "Running",
    content:
      "10 KM running arround house area"
  }
];

const intialState: TodoAppState = {
  list: data,
  selectedTodo: undefined
};

const todos = (state = intialState, action: any): TodoAppState => {
  switch (action.type) {
    case ADD_TODO: {
      const list = [...state.list];
      list.push(action.item as ITodoListItem);
      return { ...state, list };
    }
    case GET_TODO: {
      const selectedTodo = [
        ...state.list.filter(item => item.id === action.id)
      ][0];
      return { ...state, selectedTodo };
    }
    case EDIT_TODO: {
      const { id, content, name , category} = action.item as ITodoListItem;
      const list = [
        ...state.list.map(item =>
          item.id === id ? { ...item, category, name, content } : item
        )
      ];

      return { ...state, list };
    }
    case REMOVE_SELECTED_TODO: {
      const selectedTodo = undefined;
      return { ...state, selectedTodo };
    }

    case DELETE_TODO: {
      const list = [...state.list];
      const filteredList = list.filter(
        (item: ITodoListItem) => item.id !== (action.id as string)
      );
      return { ...state, list: filteredList };
    }

    default: {
      return state;
    }
  }
};
export default todos;
