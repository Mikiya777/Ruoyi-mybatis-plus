import request from "@/utils/request";

export function getExperimentByTeacher(data) {
  return request({
    url: "/teacher/getExperiment",
    method: "get",
    params: data,
  });
}

export function getDegital(user_id,exp_id){
  return request({
    url: `/teacher/getAnswer/${user_id}/${exp_id}`,
    method:"get",
  })
}
