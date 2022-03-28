<template>
  <div class="container ml-10 mt-5">
    <product-header :devkey="$route.params.id"></product-header>
    <product-badges></product-badges>
    <product-job></product-job>
    <product-description></product-description>
    <product-buttons></product-buttons>
    </div>

</template>

<script>

import ProductDescription from "@/components/ProductDescription";
import ProductHeader from "@/components/ProductHeader";
import ProductJob from "@/components/ProductJob";
import ProductBadges from "@/components/Product-Badges";
import ProductButtons from "@/components/ProductButtons";

export default {
  name: "ProductOverview",
  components: { ProductButtons, ProductBadges, ProductJob, ProductHeader, ProductDescription,}
}
</script>

<style scoped>

</style>