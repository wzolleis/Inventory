
const state = () => {
    return{
        product: null
    }
};

const getters = {
    getProductData(state){
        return state.product

    }
};

const actions = {
    setData(){

    }


};

const mutations = {
    SET_PRODUCT(state, payload) {
        state.product = payload;
    },
    SET_PRODUCT_INFORMATION(state, information, payload){
        state.product[information] = payload;
    }
};

export default {
    namespaced: true,
    state,
    getters,
    actions,
    mutations,
};