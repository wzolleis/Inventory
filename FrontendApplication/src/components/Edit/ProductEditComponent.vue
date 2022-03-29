<template>
  <div class="container">
    <div class="mx-3 mt-10 space-y-3" v-if="loaded">


      <p class="font-bold text-2xl">Artikel bearbeiten</p>
      <div>
        <p class="my-0 text-gray-400 text-sm mb-2">Artikelname:</p>
        <input type="text" v-model="product.name" class=" w-full rounded bg-gray-200 p-2 font-bold">
      </div>

      <div class="grid grid-cols-2 gap-3">

        <div>
          <p class="my-0 text-gray-400 text-sm flex mb-1">Kategorie</p>
          <select name="Select" id="1" v-model=selection.selectedCategory
                  class="p-2 font-bold select rounded w-full bg-gray-200 border-none checked:bg-red-500 border-none">
            <option v-for="option in selection.categoryOptions" :key="option.length" class="">{{ option.name }}</option>
          </select>
        </div>

        <div>
          <p class="my-0 text-gray-400 text-sm flex mb-1">Position</p>
          <select name="Select" id="2" v-model=selection.selectedPosition
                  class="p-2 font-bold select rounded w-full bg-gray-200  border-none checked:bg-red-500 border-none">
            <option v-for="option in selection.positionOptions" :key="option.length" class="font-bold">{{ option.name }}</option>
          </select>
        </div>


      </div>

      <div>
        <p class="my-0 text-gray-400 text-sm mb-2">Beschreibung:</p>
        <input type="text" v-model="product.description" class=" w-full rounded bg-gray-200 p-2 font-bold">
      </div>
      <div>
        <p class="my-0 text-gray-400 text-sm mb-2">Menge:</p>
        <input type="text" v-model="product.quantity" class="w-full rounded bg-gray-200 p-2 font-bold">
      </div>
      <div>
        <div>
        </div>
      </div>
    </div>
  </div>

</template>

<script>
import storeData from "@/JS/mixins/storeData";


export default {
  name: "ProductEditComponent",
  components: {},
  mixins: [storeData],
  async created() {
    await this.storeData("product", this.$route.params.id);
    await this.storeData("category", "all");
    await this.storeData("position", "all")
    this.setProductData();
  },
  data() {
    return {
      loaded: false,
      product: null,
      selection: {
        categoryOptions: [],
        selectedCategory: {},
        positionOptions: [],
        selectedPosition: {}
      },


    }
  },
  methods: {
    setProductData() {
      this.product = this.getData("product", this.$route.params.id)
      this.selection.categoryOptions = this.getData("category", "all");
      this.selection.selectedCategory = this.product.category.position;
      this.selection.positionOptions = this.getData("position", "all");
      this.selection.selectedPosition = this.product.position.name;
      this.loaded = true;
    },

    storeProcuctData(){
      this.product.position = this.selection.selectedPosition;
      this.product.category = this.selection.selectedCategory;
    }


  }
}
</script>
