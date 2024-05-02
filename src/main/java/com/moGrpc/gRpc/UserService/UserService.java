package com.moGrpc.gRpc.UserService;

import com.moGrpc.gRpc.APIResponse;
import com.moGrpc.gRpc.UserGrpc;
import com.moGrpc.gRpc.loginRequest;
import io.grpc.stub.StreamObserver;

public class UserService extends UserGrpc.UserImplBase {
    @Override
    public void login(loginRequest request, StreamObserver<APIResponse> responseObserver) throws InterruptedException {
        APIResponse.Builder response = APIResponse.newBuilder();
        if(request.getUsername().equals(request.getPassword())){
            response.setResponseCode("0").setStatus("success").build();
        } else {
            response.setResponseCode("-1").setStatus("failed").build();
        }
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }
}
