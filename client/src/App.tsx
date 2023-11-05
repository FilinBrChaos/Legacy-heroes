import { RouterProvider, createBrowserRouter } from 'react-router-dom';
import { Root } from './components/Root';
import RewardsPage from "./pages/RewardsPage";
import users from "./mocked data/users.json";

const router = createBrowserRouter([
  {
    path: "/",
    element: <Root />,
    loader: async () => {
      return users;
    },
  },
  {
    path: '/rewards',
    element: <RewardsPage />,
    loader: () => {
      return '';
    },
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
