<template>
  <div>
    <div class="flex space-x-2 ">
      <product-badge :content="'Lagerbestand: '+ this.getData('product', this.productID).quantity "></product-badge>
    </div>
    <div class="flex space-x-2 mt-2">
    </div>
    <div class="flex space-x-4">
      <product-information :position="this.getData('product', this.productID).position.name"
                           description="Position" pos></product-information>
      <product-information :position="'#' + this.getData('product', this.productID).id" description="Barcode"
                           v-bind:pos="false"></product-information>
      <product-information :position="this.getData('product', this.productID).category.position" description="Kategorie"
                           v-bind:pos="false" category></product-information>
    </div>
  </div>
</template>

<script>
import ProductBadge from "@/components/ProductBadge";
import ProductInformation from "@/components/ProductInformation";
import storeData from "@/JS/mixins/storeData";

export default {
  name: "Product-Badges",
  created() {
  },
  data(){
    return {
      productID: this.$route.params.id
    }
  },
  components: {
    ProductInformation,
    ProductBadge

  },
  mixins: [storeData]
}
</script>

<style scoped>

</style>