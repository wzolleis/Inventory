import { createStore } from 'vuex'
import Jobs from "@/store/modules/AllJobs";
import JobInformation from "@/store/modules/JobInformation";
import ProductInformation from "@/store/modules/ProductInformation";
import Workshop from "@/store/modules/Workshop";

const state = {
  response: null,
}

const mutations = {
  SET_RESPONSE(state, payload){
    state.response = payload
  }


}
export default createStore({
  state,
  getters: {
    getResponseData(){
      console.log(state.response);
      return state.response

    }
  },
  namespaced: true,
  mutations,
  actions: {
  },
  modules: {
    ProductInformation,
    JobInformation,
    Jobs,
    Workshop
  }
})
