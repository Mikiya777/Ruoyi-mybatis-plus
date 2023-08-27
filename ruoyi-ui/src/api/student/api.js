import request from "@/utils/request";

export function startExercise() {
  return request({
    url: "/experiment/createExp",
    method: "get",
  });
}

export function pushAnswer(data) {
  return request({
    url: "/answers/submit",
    method: "post",
    data: data,
  });
}

export function getSchedule(data) {
  return request({
    url: "/schedule/get",
    method: "get",
    params: data,
  });
}
export function getExperiment(data) {
  return request({
    url: "/experiment/get",
    method: "get",
    params: data,
  });
}
export function getExpDetail(data) {
  return request({
    url: `/answers/get/${data}`,
    method: "get",
  });
}
