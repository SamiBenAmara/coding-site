import { createBrowserRouter, RouterProvider } from 'react-router-dom'
import './App.css'
import LandingPage from './components/LandingPage/LandingPage'
import LoginSignupPage from './components/LoginSignupPage/LoginSignupPage';

const router = createBrowserRouter([

  {
    path: '/',
    element: <LandingPage />,
  },
  {
    path: '/login-signup',
    element: <LoginSignupPage />,
  },

]);

const App: React.FC = () => {

  return (
    <RouterProvider router={router} />      
  )
}

export default App
