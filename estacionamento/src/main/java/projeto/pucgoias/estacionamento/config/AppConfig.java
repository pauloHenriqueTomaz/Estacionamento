package projeto.pucgoias.estacionamento.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Classe de configuracao da aplicacao
 * @author Paulo Henrique
 *
 */
@Configuration
@EnableTransactionManagement
@ComponentScans(value = { @ComponentScan("projeto.pucgoias.estacionamento"),
@ComponentScan("projeto.pucgoias.estacionamento") })
public class AppConfig {

   @Bean
   public LocalEntityManagerFactoryBean getEntityManagerFactoryBean() {
      LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
      factoryBean.setPersistenceUnitName("estacionamento");
      return factoryBean;
   }

   @Bean
   public JpaTransactionManager geJpaTransactionManager() {
      JpaTransactionManager transactionManager = new JpaTransactionManager();
      transactionManager.setEntityManagerFactory(getEntityManagerFactoryBean().getObject());
      return transactionManager;
   }
}
