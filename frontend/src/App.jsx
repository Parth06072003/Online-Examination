import './App.css';
import {createBrowserRouter,RouterProvider} from 'react-router-dom';
import Login from './pages/Login';

function App() {

  const appRouter=createBrowserRouter([
    {
      path:"/login",
      element:<Login/>
    }
  ])

  return (
    <div>
  <RouterProvider router={appRouter} />
    </div>
  )
}


export default App;
