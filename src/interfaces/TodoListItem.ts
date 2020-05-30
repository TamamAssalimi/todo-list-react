export interface ITodoListItem {
  id?: string;
  name?: string;
  content?: string;
  category?: string;
}
export interface ITodoAdd {
  item?: ITodoListItem;
  handleAddNewItem?: Function;
}
