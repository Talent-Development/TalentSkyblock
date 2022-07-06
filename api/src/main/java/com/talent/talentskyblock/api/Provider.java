package com.talent.talentskyblock.api;

import java.util.Objects;

import com.talent.talentskyblock.common.util.Assert;
import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("SpellCheckingInspection")
@UtilityClass
public class Provider {

  /**
   * the skyblock instance.
   */
  @Nullable
  private Skyblock skyblock;

  /**
   * obtains the skyblock.
   *
   * @return skyblock.
   */
  @SuppressWarnings("unused")
  @NotNull
  public Skyblock skyblock() {
    return Objects.requireNonNull(Provider.skyblock, "The skyblock not set yet!");
  }

  /**
   * sets the skyblock.
   *
   * @param skyblock the skyblock to set.
   *
   * @throws IllegalStateException if the skyblock is already set.
   */
  public void skyblock(@NotNull final Skyblock skyblock) {
    Assert.isTrue(Provider.skyblock == null, "The skyblock has been set already!");
    Provider.skyblock = skyblock;
  }
}
