<template>
  <div class="container mx-3 mt-10 space-y-2" v-if="loaded">



    <p class="font-bold text-xl">Artikel bearbeiten</p>
    <div>
      <p class="my-0 text-gray-400 text-sm">Artikelname:</p>
      <input type="text" v-model="product.name" class=" w-full rounded bg-gray-200 p-2 font-bold">
    </div>
    <div class="my-0 text-gray-400 text-sm flex">Kategorie</div>

    <div>
      <p class="my-0 text-gray-400 text-sm">Beschreibung:</p>
      <input type="text" v-model="product.description" class="rounded bg-gray-200 p-2 font-bold">
    </div>
    <div>
      <p class="my-0 text-gray-400 text-sm">Menge:</p>
      <input type="text" v-model="product.quantity" class="rounded bg-gray-200 p-2 font-bold">
    </div>
    <div>
      <div>
      </div>
    </div>

    <product-buttons></product-buttons>
  </div>

</template>

<script>
import ProductButtons from "@/components/ProductButtons";
import storeData from "@/JS/mixins/storeData";
export default {
  name: "ProductEditComponent",
  components: {ProductButtons},
  mixins: [storeData],
  async created() {
    await this.storeData("product", this.$route.params.id)
    this.product = this.getData("product", this.$route.params.id)
    this.loaded = true;
  },
  data() {
    return {
     loaded: false,
      product: null


    }
  }
}
</script>
