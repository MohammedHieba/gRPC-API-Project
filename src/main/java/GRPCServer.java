import com.moGrpc.gRPCdemo.GRpCdemoApplication;
import com.moGrpc.gRpc.UserService.UserService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.boot.SpringApplication;

import java.io.IOException;

public class GRPCServer {

    public static void main(String[] args) throws IOException, InterruptedException {

        Server server = ServerBuilder.forPort(8691).addService(new UserService()).build();

       server.start();
        System.out.println("server started at" + server.getPort());
        server.awaitTermination();
    }

}
