import httpCommon from "../http-common";

class Usuario {
    getAll() {
        return httpCommon.get("/usuario");
    }

    get(id) {
        return httpCommon.get(`/usuario/${id}`);
    }

    getArea(area) {
        return httpCommon.get(`/usuario/area/${area}`);
    }

    create(data) {
        return httpCommon.post("/usuario", data);
    }

    update(id, data) {
        return httpCommon.put(`/usuario/${id}`, data);
    }
}

export default new Usuario();