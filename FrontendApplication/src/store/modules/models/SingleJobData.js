

const state = () => {
    return {
        job: null
    }
};

const getters = {
    getJobData(state) {
        console.log(state.job);
        return state.job

    }
};

const actions = {};
const mutations = {
    SET_JOB(state, payload) {
        state.job = payload;
        console.log(state.job);
    },
    SET_JOB_INFORMATION(state, information, payload) {
        state.job[information] = payload;
    }
};

export default {
    namespaced: true,
    state,
    getters,
    actions,
    mutations,
};