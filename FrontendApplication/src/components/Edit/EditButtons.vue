<template>
  <div class="space-y-4">
  <div class="flex justify-center">
    <button @click="saveButton" class=" text-sm bg-indigo-600 rounded-xl p-3 w-100 font-bold text-white ">
      Speichern
    </button>
  </div>
    <div class="flex justify-center">
      <button @click="deleteButton" class="text-sm bg-red-500 rounded-xl p-3 w-100 font-bold text-white ">
        Löschen
      </button>
    </div>

  </div>
</template>

<script>
export default {
  name: "EditButtons",
  methods: {
    saveButton(){
      this.$emit('save')
    },
    deleteButton(){
      this.$emit('delete')
    }


  }
}
</script>

<style scoped>

</style>