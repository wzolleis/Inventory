
const state = {
    job: null
};

const getters = {
    getJobData(state){
        return state.job

    }
};

const actions = {};

const mutations = {
    SET_JOB(state, payload) {
        state.job = payload;
    },
};

export default {
    state,
    getters,
    actions,
    mutations,
};