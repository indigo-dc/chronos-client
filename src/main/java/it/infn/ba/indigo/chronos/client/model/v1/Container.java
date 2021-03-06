package it.infn.ba.indigo.chronos.client.model.v1;

import it.infn.ba.indigo.chronos.client.utils.ModelUtils;

import java.io.Serializable;
import java.util.Collection;

public class Container implements Serializable {

  private static final long serialVersionUID = 4299892262923776898L;

  private String type;
  private String image;
  private Boolean forcePullImage;
  private String network;
  private Collection<Volume> volumes;
  private Collection<Parameters> parameters;

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public Boolean isForcePullImage() {
    return forcePullImage;
  }

  public void setForcePullImage(Boolean forcePullImage) {
    this.forcePullImage = forcePullImage;
  }

  public String getNetwork() {
    return network;
  }

  public void setNetwork(String network) {
    this.network = network;
  }

  public Collection<Volume> getVolumes() {
    return volumes;
  }

  public void setVolumes(Collection<Volume> volumes) {
    this.volumes = volumes;
  }

  public Collection<Parameters> getParameters() {
    return parameters;
  }

  public void setParameters(Collection<Parameters> parameters) {
    this.parameters = parameters;
  }

  @Override
  public String toString() {
    return ModelUtils.toString(this);
  }
}
