package br.com.falberto.gestao_vagas.modules.company.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity(name = "company")
@Data
public class CompanyEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  private String name;

  @Pattern(regexp = "\\S+", message = " O campo [username] não deve conter espaços")
  private String username;

  @Email(message = "O campo [email] deve conter um email válido")
  @NotBlank
  private String email;

  @Length(min = 7, max = 1000, message = "O campo [senha] deve ter entre 7 a 100 caracteres")
  @NotBlank
  private String password;
  @NotBlank
  private String webSite;
  private String description;

  @CreationTimestamp
  private LocalDateTime createdAt;
}
