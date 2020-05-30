import React, { Fragment, lazy } from "react";

import { useDispatch, useSelector } from "react-redux";
import { DeleteTodo } from "../../../store/actions/todo.action";
import { IState } from "../../../interfaces/State";
import SuspenseContainer from "../../../shared/Loader/Loader";
import { getTodoList } from "../../../store/selectors/todo.selector";

import TextField from "@material-ui/core/TextField";
import styled from "styled-components";
/**
 * Lazy loading imports
 */

const TodoListContainer = lazy(() =>
  import("../../stateless/TodoListContainer/TodoListContainer")
);

const Div = styled.div`
  padding: 0 10px;
`;

const Text = styled(TextField)`
  margin: 10px auto;
`;

// let unsubscribe: any;

const TodoHome = (props: any) => {
  const dispatch = useDispatch();
  const list = useSelector((state: IState) => getTodoList(state));

  return (
    <Div>
      <Text
        id="search-term"
        label="Find activity..."
        variant="outlined"
        fullWidth
        // onKeyDown={e => onEnter(e)}
        // onChange={e => setTerm(e.target.value)}
      />
    <Fragment>
    <SuspenseContainer>
      <TodoListContainer
        onRemoveItem={(id: string) => dispatch(DeleteTodo(id))}
        list={list}
      />
    </SuspenseContainer>
  </Fragment>
  </Div>
  );

};
export default TodoHome;
