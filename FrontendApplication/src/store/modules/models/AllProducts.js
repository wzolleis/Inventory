
const state = () => {
    return{
        products: null
    }
};

const getters = {
    getProductData(state){
        return state.product

    }
};

const actions = {
};

const mutations = {
    SET_PRODUCTS(state, payload) {
        state.products = payload;
    },
    SET_PRODUCT_INFORMATION(state, information, payload){
        state.products[information] = payload;
    }
};

export default {
    namespaced: true,
    state,
    getters,
    actions,
    mutations,
};