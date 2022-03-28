<template>
  <job-detail v-if="loaded"></job-detail>
</template>

<script>
import JobDetail from "@/components/JobDetail";
export default {
  name: "OneJob",
  components: {JobDetail},
  data(){
    return{
      loaded: false
    }
  },
  async created() {
    this.loaded = true
  }
}
</script>
