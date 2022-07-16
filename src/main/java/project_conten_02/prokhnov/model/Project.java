package project_conten_02.prokhnov.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private long projectId;

    @Column(name = "project_name")
    @Size(min = 4, max = 32, message = "Project name must have between 4 and 32 characters.")
    @NotEmpty(message = "Project name is required!")
    private String projectName;

    @Column(name = "project_description")
    private String projectDescription;

    @Column(name = "project_create_date")
    private Date projectCreateDate;

    @Column(name = "project_update_date")
    private Date projectUpdateDate;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id")
    private List<Component> projectComponent;

    public void addComponent(Component component){

        if (projectComponent == null){
            projectComponent = new ArrayList<>();
        }

        component.setComponentCreateDate(new Date());

        projectComponent.add(component);
    }

}
