package dao;

import model.Cliente;
import factory.ConexaoFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import repository.ClienteRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("tbl_cliente")
public class ClienteEndPoint {
    private final ClienteRepository clienteDao;


    @Autowired
    public ClienteEndPoint(ClienteRepository clienteDao) {
        this.clienteDao = clienteDao;
    }

    @RequestMapping(path = "/lavajato/cliente/{cliente}")
    public ResponseEntity listarCliesntes(@PathVariable Cliente cliente) {
        return clienteDao.findAll(cliente)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    public static void insert(Cliente cliente) {
        String sql = "INSERT INTO `lavajato`.`tbl_cliente` (`nome`, `contato`, `cpf`) VALUES (?, ?, ?);";
        try (Connection conn = ConexaoFactory.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getContato());
            ps.setString(3, cliente.getCpf());
            ps.execute();
            System.out.println("Registro criado com sucesso");
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(Cliente cliente) {
        if (cliente == null || cliente.getId() == 0) {
            System.out.println("Não há clinete registrado");
            return;
        }
        String slq = "UPDATE `lavajato`.`tbl_cliente` SET `nome` = ?, `contato` = ?,`cpf`= ? WHERE `id_Cliente` = ?;";
        try (Connection conn = ConexaoFactory.getConexao();
             PreparedStatement ps = conn.prepareStatement(slq);) {
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getContato());
            ps.setString(3, cliente.getCpf());
            ps.setInt(4, cliente.getId());
            ps.executeUpdate();
            System.out.println("Registro Atualizado com sucesso");
        } catch (SQLException exception) {
            exception.printStackTrace();
        }


    }

    public static void delete(Cliente cliente) {
        if (cliente == null || cliente.getId() == 0) {
            System.out.println("Não há clinete registrado");
        }
        String sql = "DELETE FROM `lavajato`.`tbl_cliente` WHERE `id_Cliente` = ?;";
        try (Connection conn = ConexaoFactory.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setInt(1, cliente.getId());
            ps.executeUpdate();
            System.out.println("Registro Deletado");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public static List<Cliente> listAll(Cliente cliente) {
//        String sql = "SELECT id_Cliente, nome, contato, cpf FROM lavajato.tbl_cliente;";
//        List<Cliente> clienteList = new ArrayList<>();
//        try (Connection conn = ConexaoFactory.getConexao();
//             PreparedStatement ps = conn.prepareStatement(sql);
//             ResultSet rs = ps.executeQuery();) {
//            while (rs.next()) {
//                clienteList.add(new Cliente(rs.getInt("id_Cliente"), rs.getString("nome"),
//                        rs.getString("contato"), rs.getString("cpf")));
//            }
//            return clienteList;
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

//    public static List<Cliente> searchByName(String nome) {
//        String sql = "SELECT id_Cliente, nome, contato, cpf FROM lavajato.tbl_cliente where nome LIKE ?";
//        List<Cliente> clienteList = new ArrayList<>();
//        try (Connection conn = ConexaoFactory.getConexao();
//             PreparedStatement ps = conn.prepareStatement(sql);) {
//            ps.setString(1, "%" + nome + "%");
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                clienteList.add(new Cliente(rs.getInt("id_CLiente"), rs.getString("nome"),
//                        rs.getString("contato"), rs.getString("cpf")));
//            }
//            ConexaoFactory.close(conn, ps, rs);
//            return clienteList;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    public static Cliente searchById(Integer id_Cliente) {
        String sql = "SELECT id_Cliente, nome, contato, cpf FROM lavajato.tbl_cliente where id_Cliente= ?";
        Cliente cliente = null;
        try (Connection conn = ConexaoFactory.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setInt(1, id_Cliente);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cliente = new Cliente(rs.getInt("id_Cliente"), rs.getString("nome"),
                        rs.getString("contato"), rs.getString("cpf"));
            }
            ConexaoFactory.close(conn, ps, rs);
            return cliente;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
