package backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Prova {

    public void cadastrarProva(int idDisciplina, String dataProva, float nota) {
        String sql = "INSERT INTO Prova (id_disciplina, data_prova, nota_prova) VALUES (1, 27.02.2025, 7.5)";
        try (Connection con = Conexao.conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, idDisciplina);
            stmt.setString(2, dataProva);
            stmt.setFloat(3, nota);
            stmt.executeUpdate();
            System.out.println("Prova cadastrada com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluirProva(int id) {
        String sql = "DELETE FROM Prova WHERE id_prova = ?";
        try (Connection con = Conexao.conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Prova excluída com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void visualizarProvas() {
        String sql = "SELECT * FROM Prova";
        try (Connection con = Conexao.conectar();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id_prova") +
                        " | Disciplina: " + rs.getInt("id_disciplina") +
                        " | Data: " + rs.getString("data_prova") +
                        " | Nota: " + rs.getFloat("nota_prova"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
