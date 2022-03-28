import { createRouter, createWebHistory } from 'vue-router'
import OneJob from "@/views/OneJob";
import EditProduct from "@/views/Edit/EditProduct";
import JobSummary from "@/views/JobSummary";
import Locations from "@/views/Locations";
import WorkshopOverview from "@/components/Workshop/WorkshopOverview";
import Product from "@/views/Product";
import TestView from "@/views/TestView";

 const routes = [
  {
    path: '/product/:id',
    name: 'Product',
    component: Product
  },
  {
    path: '/product/:id/edit',
    name: 'EditProduct',
    component: EditProduct
  },
  {
    path: '/job/:id',
    name: 'job',
    component: OneJob
  },
  {
    path: '/jobs',
    name: 'Jobs',
    component: JobSummary
  },
  {
    path: '/locations',
    name: 'Locations',
    component: Locations
  },
  {
    path: '/workshop',
    name: 'Workshop',
    component: WorkshopOverview
  },
  {
    path: '/test/:id',
    name: 'test',
    component: TestView
  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
