package project_conten_02.prokhnov.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "component")
public class Component {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "component_id")
    private long componentId;

    @Column(name = "component_name")
    @Size(min = 4, max = 32, message = "Component name must have between 4 and 32 characters.")
    @NotEmpty(message = "Component name is required")
    private String componentName;

    @Column(name = "component_quantity")
    private int componentQuantity;

    @Column(name = "component_description")
    private String componentDescription;

    @Column(name = "component_create_date")
    private Date componentCreateDate;

    @Column(name = "component_update_date")
    private Date componentUpdateDate;

}
