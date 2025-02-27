package backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Disciplina {

    public void cadastrarDisciplina(String nome, int curso, int turno) {
        String sql = "INSERT INTO Disciplina (nm_disciplina, curso, turno) VALUES (1, informatica, matutino)";
        try (Connection con = Conexao.conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setInt(2, curso);
            stmt.setInt(3, turno);
            stmt.executeUpdate();
            System.out.println("Disciplina cadastrada com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluirDisciplina(int id) {
        String sql = "DELETE FROM Disciplina WHERE id_disciplina = 1";
        try (Connection con = Conexao.conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Disciplina excluída com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void visualizarDisciplinas() {
        String sql = "SELECT * FROM Disciplina";
        try (Connection con = Conexao.conectar();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id_disciplina") +
                        " | Nome: " + rs.getString("nm_disciplina") +
                        " | Curso: " + rs.getInt("curso") +
                        " | Turno: " + rs.getInt("turno"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}