import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import Home from './components/home/Home';
import PageNotFound from './components/page-not-found/PageNotFound';
import Timeline from './components/timeline/Timeline';
import {
  createBrowserRouter,
  RouterProvider,
} from "react-router-dom";

const router = createBrowserRouter([
  {path: "/", element: <Home/> },
  { path: '/timelines/:id', element: <Timeline/>},
  {path: '*', element: <PageNotFound/>}
]);

const root = ReactDOM.createRoot(
  document.getElementById('root') as HTMLElement
);
root.render(
    <>
        <RouterProvider router={router} />
        <footer>Daniel Parvin - 2023</footer>
    </>
);
