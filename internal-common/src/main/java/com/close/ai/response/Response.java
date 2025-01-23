package com.close.ai.response;

import com.close.ai.enums.ResponseCode;
import lombok.Data;

/**
 * @author nbwyctf
 * @since 2025-01-19
 */
@Data
public class Response<T> {
    private Integer errorCode;
    private String message;
    private T data;

    public Response() {
    }

    public Response(ResponseCode code, T data) {
        this.errorCode = code.getCode();
        this.message = code.getMessage();
        this.data = data;
    }

    public static <T> Response<T> response(ResponseCode code){
        if (code == ResponseCode.OK) {
            return Response.success();
        }
        return Response.fail(code);
    }

    public static <T> Response<T> response(ResponseCode code, String msg, T data){
        if (code == ResponseCode.OK) {
            return Response.success(data);
        }
        return Response.fail(code, msg, data);
    }

    public static <T> Response<T> success() {
        Response<T> response = new Response<>();
        response.setErrorCode(ResponseCode.OK.getCode());
        response.setMessage(ResponseCode.OK.getMessage());
        return response;
    }

    public static <T> Response<T> success(T data) {
        Response<T> response = new Response<>();
        response.setData(data);
        response.setErrorCode(ResponseCode.OK.getCode());
        response.setMessage(ResponseCode.OK.getMessage());
        return response;
    }

    public static <T> Response<T> fail(ResponseCode code) {
        Response<T> response = new Response<>();
        response.setErrorCode(code.getCode());
        response.setMessage(code.getMessage());
        return response;
    }

    public static <T> Response<T> fail(ResponseCode code, String msg) {
        Response<T> response = new Response<>();
        response.setErrorCode(code.getCode());
        response.setMessage(msg);
        return response;
    }

    public static <T> Response<T> fail(ResponseCode code, String msg, T data) {
        Response<T> response = new Response<>();
        response.setErrorCode(code.getCode());
        response.setMessage(msg);
        response.setData(data);
        return response;
    }

}
