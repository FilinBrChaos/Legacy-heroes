import { RouterProvider, createBrowserRouter } from 'react-router-dom';
import { Root } from './components/Root';

const router = createBrowserRouter([
  {
    path: "/",
    element: <Root />,
    loader: () => { return '' },
  },
]);

function App() {
  return (
    <>
      <RouterProvider router={router} />
    </>
  );
}

export default App;
