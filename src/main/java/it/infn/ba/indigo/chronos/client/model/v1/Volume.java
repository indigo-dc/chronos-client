package it.infn.ba.indigo.chronos.client.model.v1;

import it.infn.ba.indigo.chronos.client.utils.ModelUtils;

import java.io.Serializable;

public class Volume implements Serializable {

  private static final long serialVersionUID = 4299892262923776898L;

  private String containerPath;
  private String hostPath;
  private String mode;

  public String getContainerPath() {
    return containerPath;
  }

  public void setContainerPath(String containerPath) {
    this.containerPath = containerPath;
  }

  public String getHostPath() {
    return hostPath;
  }

  public void setHostPath(String hostPath) {
    this.hostPath = hostPath;
  }

  public String getMode() {
    return mode;
  }

  public void setMode(String mode) {
    this.mode = mode;
  }

  @Override
  public String toString() {
    return ModelUtils.toString(this);
  }
}
