package dao;

import entidade.Cliente;
import entidade.Veiculo;
import factory.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VeiculoDAO {
    public VeiculoDAO() {

    }

    public static void insert(Veiculo veiculo) {
        String sql = "INSERT INTO `lavajato`.`tbl_veiculo` (`marca`, `modelo`, `placa`, `id_Cliente`) VALUES (?,?,?,?);";
        try (Connection conn = ConexaoFactory.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setString(1, veiculo.getMarca());
            ps.setString(2, veiculo.getModelo());
            ps.setString(3, veiculo.getPlaca());
            ps.setInt(4, veiculo.getCliente().getId());
            ps.execute();
            System.out.println("Registro criado com sucesso");
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void update(Veiculo veiculo) {
        if (veiculo == null || veiculo.getId() == 0) {
            System.out.println("Não há clinete registrado");
            return;
        }
        String slq = "UPDATE `lavajato`.`tbl_veiculo` SET `marca` = ?, `modelo` = ?,`placa`= ? WHERE `id_Veiculo` = ?;";
        try (Connection conn = ConexaoFactory.getConexao();
             PreparedStatement ps = conn.prepareStatement(slq);) {
            ps.setString(1, veiculo.getMarca());
            ps.setString(2, veiculo.getModelo());
            ps.setString(3, veiculo.getPlaca());
            ps.setInt(4, veiculo.getId());
            ps.executeUpdate();
            System.out.println("Registro Atualizado com sucesso");
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public static void delete(Veiculo veiculo) {
        if (veiculo == null || veiculo.getId() == 0) {
            System.out.println("Não há clinete registrado");
        }
        String sql = "DELETE FROM `lavajato`.`tbl_veiculo` WHERE `id_Veiculo` = ?;";
        try (Connection conn = ConexaoFactory.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setInt(1, veiculo.getId());
            ps.executeUpdate();
            System.out.println("Registro Deletado");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Veiculo> listAll() {
        String sql = "SELECT id_Veiculo, marca , modelo, placa, id_Cliente FROM lavajato.tbl_veiculo;";
        List<Veiculo> veiculoList = new ArrayList<>();
        try (Connection conn = ConexaoFactory.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                Cliente c = ClienteDAO.searchById(rs.getInt("id_Cliente"));
                veiculoList.add(new Veiculo(rs.getInt("id_Veiculo"), rs.getString("marca"),
                        rs.getString("modelo"), rs.getString("placa"), c));
            }
            return veiculoList;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Veiculo> listarVeiculos() {
        List<Veiculo> veiculoList = VeiculoDAO.listAll();
        for (int i = 0; i < veiculoList.size(); i++) {
            Veiculo c = veiculoList.get(i);
            System.out.println(c.getId() + " " + c.getMarca() + " " + c.getModelo() + " " + c.getPlaca() +
                    ", Proprietário:  " + c.getCliente().getNome());
        }
        return veiculoList;
    }
}
