import { RouterProvider, createBrowserRouter } from 'react-router-dom';
import { Root } from './components/Root';
import RewardsPage from "./pages/RewardsPage";

const router = createBrowserRouter([
  {
    path: "/",
    element: <Root />,
    loader: () => { return '' },
  },
  {
    path: "/rewards",
    element: <RewardsPage />,
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
